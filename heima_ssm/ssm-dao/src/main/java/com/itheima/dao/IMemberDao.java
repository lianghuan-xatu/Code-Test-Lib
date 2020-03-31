package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberDao {

    @Select("select * from member where id= #{memberId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "email",column = "email")
    }
    )
    public Member findById(String memberId);

}
