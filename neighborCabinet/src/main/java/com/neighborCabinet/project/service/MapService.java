package com.neighborCabinet.project.service;

import java.util.ArrayList;

import com.neighborCabinet.project.model.PlaceInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neighborCabinet.project.dao.IMapDAO;
import com.neighborCabinet.project.model.MapVO;

@Service
public class MapService implements IMapService {
	@Autowired
	IMapDAO dao;

	@Override
	public ArrayList<MapVO> listAllMap() { return dao.listAllMap();
	}
	@Override
	public int searchPlace(String keyword) {return dao.searchPlace(keyword);}

}
