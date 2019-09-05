package org.canto.crawler.mapper;

import org.apache.ibatis.annotations.*;
import org.canto.crawler.pojo.ItemDropInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author morningyet
 * @create 2019-09-03 21:18
 */
@Repository
@Mapper
public interface ItemDropMapper {

    @Select("select * from items_drop where id = #{id}")
    public ItemDropInfo selectItemDropInfoById(Integer id);

    @Delete("delete from items_drop where id =#{id}")
    public int deleteItemDropInfoById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into items_drop(items_name,dungeons_id,dungeons_name,branch,floor,uni,role1,role2,role3,role4,role5,role6) " +
            "values(#{itemsName},#{dungeonsId},#{dungeonsName},#{branch},#{floor},#{uni}," +
            "#{role1},#{role2},#{role3},#{role4},#{role5},#{role6})")
    public int insertItemDropInfo(ItemDropInfo itemDropInfo);

    @Update("update items_drop set role1=#{role1}, role2=#{role2}, role3=#{role3}, role4=#{role4}, role5=#{role5}, role6=#{role6} " +
            "where id = #{id}")
    public int updateItemDropInfo(ItemDropInfo itemDropInfo);

    @Select("select * from items_drop where items_name = #{itemsName} and dungeons_name = #{dungeonsName}")
    public ItemDropInfo selectItemDropInfoByName(@Param("itemsName") String itemsName, @Param("dungeonsName") String dungeonsName);

    @Select("select * from items_drop where dungeons_name = #{dungeonsName}")
    public List<ItemDropInfo> selectItemDropInfoByDungeonsName(@Param("dungeonsName") String dungeonsName);

}
