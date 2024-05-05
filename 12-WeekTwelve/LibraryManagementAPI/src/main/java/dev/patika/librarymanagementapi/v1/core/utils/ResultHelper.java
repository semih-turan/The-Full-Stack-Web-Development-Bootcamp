package dev.patika.librarymanagementapi.v1.core.utils;

import dev.patika.librarymanagementapi.v1.core.result.Result;
import dev.patika.librarymanagementapi.v1.core.result.ResultData;
import dev.patika.librarymanagementapi.v1.dto.response.CursorResponse;
import org.springframework.data.domain.Page;

public class ResultHelper {
    public static <T> ResultData<T> CREATED(T data){
        return new ResultData<>(true,Message.OK,"201",data);
    }
    public static <T> ResultData<T> ERROR(T data){
        return new ResultData<>(false,Message.NOT_FOUND,"400",data);
    }
    public static <T> ResultData<T> OK(T data){
        return new ResultData<>(true,Message.OK,"200",data);
    }
    public static Result NOT_FOUND(){
        return new Result(false,Message.NOT_FOUND,"400");
    }
    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData){
        CursorResponse<T> cursor = new CursorResponse<>();

        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());

        return ResultHelper.OK(cursor);
    }
}
