package com.longl.unicom.yjy.reptilebid.dao;

import java.util.List;
import java.util.Map;

import com.longl.unicom.yjy.reptilebid.model.BidModel;


public interface IBidDao {

int searchlistBysame(Map map);
List searchlist(Map map);
int insert(BidModel bid);

List getzbinfolist();

List zbdetailsearch(Map map);
int insertzbdetial(Map map);

List gettongjiinfolist(Map map);

int inserttongjidetial(Map map);

int updateyghq();

}