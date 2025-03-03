package com.bootcamp.two.hw_sb_two.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.two.hw_sb_two.controller.UserOperation;
import com.bootcamp.two.hw_sb_two.dto.CommentDTO;
import com.bootcamp.two.hw_sb_two.dto.PostDTO;
import com.bootcamp.two.hw_sb_two.dto.UserCommentDTO;
import com.bootcamp.two.hw_sb_two.dto.UserDTO;
import com.bootcamp.two.hw_sb_two.dto.mapper.UserDTOMapper;
import com.bootcamp.two.hw_sb_two.exception.UserNotFoiundException;
import com.bootcamp.two.hw_sb_two.dto.mapper.UserDTOMapper;
import com.bootcamp.two.hw_sb_two.model.dto.CommentDto;
import com.bootcamp.two.hw_sb_two.model.dto.PostDto;
import com.bootcamp.two.hw_sb_two.model.dto.UserDto;
import com.bootcamp.two.hw_sb_two.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class UserController implements UserOperation{
  @Autowired
  private UserService userService;
  @Autowired
  private UserDTOMapper userDTOMapper;

  // Task 2
  @GetMapping(value = "/users")
  public List<UserDto> getUsers() {
      return this.userService.getUsers();
  }

  // Task 3a
  @GetMapping(value = "/users/mapper")
  public List<UserDTO> getJPHUsers(){
    List<UserDto> userDtos = this.userService.getUsers();
    List<PostDto> postDtos = this.postService.getPosts();
    List<CommentDto> commentDtos = this.commentService.getComments();

    //the following can be for loop:
    //null check on each returned objects from JsonPlaceHolder
    return userDtos.stream()
      .map(u -> {

        List<PostDTO> postDTOs = postDtos.stream()
          .filter(p -> p.getUserId() == u.getId)
          .map(p -> {
            List<CommentDTO> commentDTOs = commentDtos.stream()
              .filter(c -> c.getPostId() == p.getId())
              .map(c -> new CommentDTO(c.getId(), c.getName(), c.getEmail(), c.getBody())) 
              .collect(Collectors.toList());
            return PostDTO.builder()
              .id(p.getId())
              .title(p.getTitle())
              .body(p.getBody())
              .commentDTOs(commentDTOs)
              .build();
          }).collect(Collectors.toList());

          UserDTO.AddressDTO.GeoDTO geoDTO = UserDTO.AddressDTO.GeoDTO.builder()
            .latitude(u.getAddress().getGeo().getLatitude())
            .longitude(u.getAddress().getGeo().getLongitude())
            .build();
          UserDTO.AddressDTO addressDTO = UserDTO.AddressDTO.builder()
            .city(u.getAddress().getCity()).street(u.getAddress().getSuite())
            .zipcode(u.getAddress().getZipcode()).suite(u.getAddress().getSuite())
            .geo(geoDTO)
            .build();
          UserDTO.CompanyDTO companyDTO = UserDTO.CompanyDTO.builder()
            .bs(u.getCompany().getBs())
            .catchPhrase(u.getCompany().getCatchPhrase())
            .name(u.getCompany().getName())
            .build();
          return UserDTO.builder()
            .id(u.getId())
            .name(u.getName())
            .username(u.getUsername())
            .email(u.getEmail())
            .phone(u.getPhone())
            .website(u.getWebsite())
            .address(addressDTO)
            .company(companyDTO)
            //.postDTOs(postDTOs)
            .build();
      }).collect(Collectors.toList());
  }
  // public List<UserDTO> getUsersComments() {
  //     return this.userService.getUsers().stream()
  //       .map(e -> userDTOMapper.map(e))
  //       .collect(Collectors.toList());
  // }
  
  // public List<UserDTO> getAllUsersWithPosts(){
  //   return this.userService.getUsers().stream()
  //     .map(user -> {
  //       List<PostDTO> userPosts = this.postService.getPosts().stream()
  //         .filter(post -> post.getUserId().equals(user.getId()))
  //         .map(post -> {
  //           List<CommentDTO> postComments = this.commentService.getComments().stream()
  //             .filter(comment -> comment.getPostId().equals(post.getPostId()))
  //             .map(CommentDTO::new)
  //             .collect(Collectors.toList());

  //           return new PostDTO(post, postComments);
  //      })
  //     .collect(Collectors.toList());
      
  //     return new UserDTO(user, userPosts);
  //   })
  //   .collect(Collectors.toList());
  // for (int i = 0; i < e.length; i++){
    
  // }
  
  // Task 3 b
  @Override
  public List<UserCommentDTO> getUserComments(String userId){
    Long uid = Long.valueOf(userId);
    List<UserDto> userDtos = this.userService.getUsers();
    // user not found  // check if User exists
      userDtos.stream().filter(u -> u.getId() == uid)
        .findAny().orElseThrow(() -> new UserNotFoiundException());
    List<PostDto> postDtos = this.postService.getPosts();
    List<CommentDto> commentDtos = this.commentService.getComments();

    List<UserCommentDTO.CommentDTO> commentDTOs = new ArrayList<>();
    for (PostDto postDto : postDtos){
      if (postDto.getUserId() == uid){
        for (CommentDto commentDto : commentDtos){
          if (commentDto.getPostId() == postDto.getPostId()){
            commentDTOs.add(new UserCommentDTO.CommentDTO(commentDto.getName(), commentDto.getEmail(), commentDto.getBody()));
          }
        }
      }
    }
    //return this.userService.getUsers().stream()
    return userDtos.stream() //jphService.getJPHUsers
      .filter(u -> u.getId() == uid) //tbc
      .map(u -> new UserCommentDTO(u.getId(), u.getUsername(), commentDTOs)) //tbc
      .collect(Collectors.toList());

  }

  
  
}
