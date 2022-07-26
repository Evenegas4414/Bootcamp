package cl.exql.sp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cl.exql.sp.model.Users;


@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM users WHERE email = #{email}")
	Users findByEmail(@Param("email") String email);

}
