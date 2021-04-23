package com.siit.proiectfinalandreea.plantshop.service;


import com.siit.proiectfinalandreea.plantshop.entity.OrderEntity;
import com.siit.proiectfinalandreea.plantshop.entity.OrdersWithPlantsEntity;
import com.siit.proiectfinalandreea.plantshop.exception.OrderNotFoundException;
import com.siit.proiectfinalandreea.plantshop.exception.PlantNotFoundException;
import com.siit.proiectfinalandreea.plantshop.mapper.OrderMapper;
import com.siit.proiectfinalandreea.plantshop.model.*;
import com.siit.proiectfinalandreea.plantshop.repository.ClientRepository;
import com.siit.proiectfinalandreea.plantshop.repository.OrderRepository;
import com.siit.proiectfinalandreea.plantshop.repository.OrderWithPlantsRepository;
import com.siit.proiectfinalandreea.plantshop.repository.PlantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final PlantRepository plantRepository;
    private final ClientRepository clientRepository;
    private final OrderWithPlantsRepository orderWithPlantsRepository;

    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orders = orderRepository.findAll();
        List<OrderDto> ordersDTO = orderMapper.mapListEntityToListDto(orders);
        for(OrderDto orderDto:ordersDTO){
            List<OrdersWithPlantsDto> ordersWithPlantsDtos = orderDto.getPlants();

            Integer totalPrice=0;
            for(OrdersWithPlantsDto orderLine:ordersWithPlantsDtos){
                totalPrice=totalPrice+((orderLine.getPlant().getPrice()*orderLine.getNumberOfPlants()));
            }
            orderDto.setTotalPrice(totalPrice);
        }
        return ordersDTO;
    }

    public OrderDto getOrder(Integer orderId) {

        OrderEntity order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("No order for given Id  " + orderId));

        OrderDto orderDto = orderMapper.mapEntityToDto(order);

        List<OrdersWithPlantsDto> ordersWithPlantsDtos = orderDto.getPlants();

        Integer totalPrice=0;
        for(OrdersWithPlantsDto orderLine:ordersWithPlantsDtos){
            totalPrice=totalPrice+((orderLine.getPlant().getPrice()*orderLine.getNumberOfPlants()));
        }

        orderDto.setTotalPrice(totalPrice);
        return orderDto;
    }

    public OrderDto createOrder(OrderCreationRequest orderCreationRequest) {
        List<OrdersWithPlantsEntity> plants = new ArrayList<>();
        OrderEntity order = new OrderEntity();
        order.setClient(clientRepository.findById(orderCreationRequest.getClientId()).orElseThrow(() -> new PlantNotFoundException("No such id for a client  " + orderCreationRequest.getClientId())));

        orderCreationRequest.getPlantInfos().forEach(plantInfo -> plants.add(new OrdersWithPlantsEntity(order, plantRepository.findById(plantInfo.getPlantId()).orElseThrow(() -> new PlantNotFoundException("No such id for a plant  " + plantInfo.getPlantId())), plantInfo.getQuantity())));
        order.getPlants().addAll(plants);

        return orderMapper.mapEntityToDto(orderRepository.save(order));
    }
    public OrderDto addToOrder(OrderAddMoreItemsOrRemoveRequest orderAddMoreItemsRequest) {

        OrderEntity order = orderRepository.findById(orderAddMoreItemsRequest.getOrderId()).orElseThrow(() -> new OrderNotFoundException("No order found for ID  " + orderAddMoreItemsRequest.getOrderId()));
        List<PlantInfo> plantInfos = orderAddMoreItemsRequest.getPlantInfos();
        List<OrdersWithPlantsEntity>plantsAlreadyInOrder=order.getPlants();
        List<OrdersWithPlantsEntity>plantToBeAdded=new ArrayList<>();
        for(PlantInfo p:plantInfos){
            boolean isPlantAllreadyInOrder=false;
            int whereIsThePlant=0;
            for(OrdersWithPlantsEntity o:plantsAlreadyInOrder) {
                if (p.getPlantId().equals(o.getPlant().getId())) {
                    isPlantAllreadyInOrder = true;
                    whereIsThePlant = plantsAlreadyInOrder.indexOf(o);
                }
            }
            if(isPlantAllreadyInOrder){
                plantsAlreadyInOrder.get(whereIsThePlant).setNumberOfPlants(plantsAlreadyInOrder.get(whereIsThePlant).getNumberOfPlants()+p.getQuantity());
            }
            else {
                plantToBeAdded.add(new OrdersWithPlantsEntity(order, plantRepository.findById(p.getPlantId()).orElseThrow(() -> new PlantNotFoundException("No such id for a plant  " + p.getPlantId())), p.getQuantity()));
            }
            order.getPlants().addAll(plantToBeAdded);
        }
        return orderMapper.mapEntityToDto(orderRepository.save(order));
    }
    @Transactional
    public void deleteFromOrder(OrderAddMoreItemsOrRemoveRequest orderAddMoreItemsRequest){

        OrderEntity order = orderRepository.findById(orderAddMoreItemsRequest.getOrderId()).orElseThrow(() -> new OrderNotFoundException("No order found for ID  " + orderAddMoreItemsRequest.getOrderId()));
        List<PlantInfo> plantInfos = orderAddMoreItemsRequest.getPlantInfos();
        List<OrdersWithPlantsEntity>plantsAlreadyInOrder=order.getPlants();
        for(PlantInfo p:plantInfos){
            boolean isPlantAllreadyInOrder=false;
            int whereIsThePlant=0;
            for(OrdersWithPlantsEntity o:plantsAlreadyInOrder) {
                if (p.getPlantId()==(o.getPlant().getId())) {
                    isPlantAllreadyInOrder = true;
                    whereIsThePlant = plantsAlreadyInOrder.indexOf(o);
                }
            }
            if(isPlantAllreadyInOrder){
                if(plantsAlreadyInOrder.get(whereIsThePlant).getNumberOfPlants()>p.getQuantity()) {
                    plantsAlreadyInOrder.get(whereIsThePlant).setNumberOfPlants(plantsAlreadyInOrder.get(whereIsThePlant).getNumberOfPlants() - p.getQuantity());
                }else if(plantsAlreadyInOrder.get(whereIsThePlant).getNumberOfPlants().equals(p.getQuantity())){
                    orderWithPlantsRepository.deleteById(plantsAlreadyInOrder.get(whereIsThePlant).getId());
                    plantsAlreadyInOrder.remove(whereIsThePlant);
                }else
                    throw new PlantNotFoundException("You are trying to remove more plants than existing number "+p.getQuantity());
            }
            else {
                throw new PlantNotFoundException("The plant that you are trying to delete from the order, is not a part of the order: plant ID "+p.getPlantId());
            }
            if (plantsAlreadyInOrder.isEmpty()){
                orderRepository.deleteById(orderAddMoreItemsRequest.getOrderId());
            }
        }
    }
    @Transactional
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}