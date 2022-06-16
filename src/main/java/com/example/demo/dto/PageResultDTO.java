package com.example.demo.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO, ENTITY> {
    private List<DTO> dtoList;

    private int totalPage;

    private int page;

    private int size;

    private int start, end;

    private boolean prev, next;

    private List<Integer> pageList;

    public PageResultDTO(Page<ENTITY> result, Function<ENTITY, DTO> fn){
        dtoList = result.stream().map(fn).collect(Collectors.toList());
        makePageList(result);
    }

    private void makePageList(Page<ENTITY> pageResult){
        this.page = pageResult.getNumber() + 1;
        this.size = pageResult.getSize();
        this.totalPage = pageResult.getTotalPages();

        start = (int)(Math.floor((page - 1)/5.0))*5 + 1;
        end = Math.min(start+4,totalPage);

        prev = start > 1;
        next = totalPage > end;

        pageList = IntStream.rangeClosed(start,end).boxed().collect(Collectors.toList());
    }
}
