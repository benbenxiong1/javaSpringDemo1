package benbenxiong.java.demo.service;

import benbenxiong.java.demo.dto.PageDTO;
import benbenxiong.java.demo.dto.PublishDTO;
import benbenxiong.java.demo.mapper.PublishMapper;
import benbenxiong.java.demo.mapper.UserMapper;
import benbenxiong.java.demo.model.Publish;
import benbenxiong.java.demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublishService {
    @Autowired
    private PublishMapper publishMapper;

    @Autowired
    private UserMapper userMapper;

    public PageDTO<PublishDTO> getPublish(Integer page, Integer size){

        PageDTO<PublishDTO> pageList = new PageDTO<PublishDTO>();
        Integer count = publishMapper.count();
        List<Publish> publishes = publishMapper.get(page, size);
        List<PublishDTO> publishDTOList = new ArrayList<>();
        for(Publish publish : publishes){
            User user = userMapper.findById(publish.getUid());
            PublishDTO publishDTO = new PublishDTO();
            BeanUtils.copyProperties(publish,publishDTO);
            publishDTO.setUser(user);
            publishDTOList.add(publishDTO);
        }
        pageList.setList(publishDTOList);
        pageList.setPageData(count,page,size);
        return pageList;
    }
}
