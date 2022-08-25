package com.acon.dokseo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.acon.dokseo.dto.Ticket;

@Mapper
public interface TicketMapper {
	
	List<Ticket>	selectPageAll(int startRow,int pageSize);
	int	selectPageAllCount();

	Ticket selectOne(int ticketNo);
	int insertOne(Ticket ticket);
	int updateOne(Ticket ticket);
	int deleteOne(int ticketNo);
}
