package benbenxiong.java.demo.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageDTO<T> {
    private List<T> list = new ArrayList<T>(); //分页数据
    private boolean firstPage = false;   //第一页
    private boolean lastPage = false;    //上一页
    private boolean nextPage = false;    //下一页
    private boolean endPage = false;     //最后一页
    private List<Integer> pageList = new ArrayList<Integer>();
    private int page; //当前页

    public void setPageData(Integer count, Integer page, Integer size) {
        Integer pageCount = count / size;
        if(count % size !=0){
            pageCount += 1;
        }
        //当不是第一页时显示上一页按钮
        if(page != 1){
            lastPage = true;
        }
        //当不是最后一页时显示下一页按钮
        if(page != pageCount){
            nextPage = true;
        }
        //生成分页列表
        for (int i=0; i<3; i++){
            if(page - i > 0){
                pageList.add(0,page - i);
            }
            if(page + i <= pageCount){
                pageList.add(page + i);
            }
        }
        //当第一页不在分页列表数据时 显示跳转首页按钮
        if(pageList.contains(1)){
            firstPage = true;
        }
        //当最后一页不在分页列表数据时 显示跳转最后一页页按钮
        if(pageList.contains(pageCount)){
            endPage = true;
        }
    }


}
