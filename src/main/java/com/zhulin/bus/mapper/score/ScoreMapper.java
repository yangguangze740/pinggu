package com.zhulin.bus.mapper.score;

import com.zhulin.bus.bean.Score;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoreMapper extends ArcMapper<Score>{
    @Override
    @Select("SELECT scoreId, scoreContent FROM pinggu_score")
    @Results({
            @Result(id = true, column = "scoreId", property = "scoreId"),
            @Result(column = "scoreContent", property = "scoreContent")
    })
    List<Score> selectList(Score score);

    @Update("UPDATE pinggu_score SET scoreContent=#{scoreContent} WHERE scoreId=#{scoreId}")
    @Override
    boolean update(Score score);

    @Select("SELECT scoreId, scoreContent FROM pinggu_score WHERE scoreId=#{value}")
    @Results({
            @Result(id = true, column = "scoreId", property = "scoreId"),
            @Result(column = "scoreContent", property = "scoreContent")
    })
    @Override
    Score selectDetail(String id);

    @Insert("INSERT INTO pinggu_score (scoreId, scoreContent) VALUES (#{scoreId}, #{scoreContent})")
    @Override
    boolean insert(Score score);

    @Delete("DELETE FROM pinggu_score WHERE scoreId=#{value}")
    @Override
    boolean delete(String id);
}
