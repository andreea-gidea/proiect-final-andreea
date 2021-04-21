package com.siit.proiectfinalandreea.plantshop.service;


import com.siit.proiectfinalandreea.plantshop.entity.OrderEntity;
import com.siit.proiectfinalandreea.plantshop.entity.OrdersWithPlantsEntity;
import com.siit.proiectfinalandreea.plantshop.entity.PlantEntity;
import com.siit.proiectfinalandreea.plantshop.exception.OrderNotFoundException;
import com.siit.proiectfinalandreea.plantshop.exception.PlantNotFoundException;
import com.siit.proiectfinalandreea.plantshop.mapper.OrderMapper;
import com.siit.proiectfinalandreea.plantshop.model.OrderCreationRequest;
import com.siit.proiectfinalandreea.plantshop.model.OrderDto;
import com.siit.proiectfinalandreea.plantshop.model.OrdersWithPlantsDto;
import com.siit.proiectfinalandreea.plantshop.repository.ClientRepository;
import com.siit.proiectfinalandreea.plantshop.repository.OrderRepository;
import com.siit.proiectfinalandreea.plantshop.repository.PlantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final PlantRepository plantRepository;
    private final ClientRepository clientRepository;

    public List<OrderDto> getAllOrders() {
        return orderMapper.mapListEntityToListDto(orderRepository.findAll());
    }

    public OrderDto getOrder(Integer orderId) {

//        OrderEntity order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("No order for given Id  " + orderId));
//        List<OrdersWithPlantsEntity> ordersWithPlantsEntities = order.getPlants();
//
//        Integer totalPrice=0;
//        for(int i=0;i<ordersWithPlantsEntities.size();i++){
//            totalPrice=totalPrice+1;
//        }
//        OrderDto orderDto = orderMapper.mapEntityToDto(order);
//
//        orderDto.setTotalPrice(totalPrice);
        return orderMapper.mapEntityToDto(orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("No order for given Id  " + orderId)));
    }

    public OrderDto createOrder(OrderCreationRequest orderCreationRequest) {
        List<OrdersWithPlantsEntity> plants = new ArrayList<>();
        OrderEntity order = new OrderEntity();
        order.setClient(clientRepository.findById(orderCreationRequest.getClientId()).orElseThrow(() -> new PlantNotFoundException("No such id for a client  " + orderCreationRequest.getClientId())));

        orderCreationRequest.getPlantInfos().forEach(plantInfo -> plants.add(new OrdersWithPlantsEntity(order, plantRepository.findById(plantInfo.getPlantId()).orElseThrow(() -> new PlantNotFoundException("No such id for a plant  " + plantInfo.getPlantId())), plantInfo.getQuantity())));
        order.getPlants().addAll(plants);

        return orderMapper.mapEntityToDto(orderRepository.save(order));
    }
}
