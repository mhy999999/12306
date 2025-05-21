package com.example.tickets.controller;

import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.dto.ButTicketDTO;
import com.example.tickets.pojo.entity.Tickets;
import com.example.tickets.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    /**
     * 查询某用户所有票务信息
     * @param realName
     * @return
     */
    @CrossOrigin(origins = "")
    @GetMapping("/ticket")
    public Result getTicketByName(@RequestParam String realName){

        List<Tickets> list = ticketService.getTicketByName(realName);
        log.info("查询所有票务信息:{}",list);

        return Result.success(list);
    }

    /**
     * 购买车票
     * @param butTicketDTO
     * @return
     */
    @CrossOrigin(origins = "")
    @PostMapping("/ticket/buy")
    public Result buyTicket(@RequestBody ButTicketDTO butTicketDTO) {

        List<Tickets> list = ticketService.buyTicket(butTicketDTO);
//        log.info("查询所有票务信息:{}",list);

        return Result.success(list);
    }

}
