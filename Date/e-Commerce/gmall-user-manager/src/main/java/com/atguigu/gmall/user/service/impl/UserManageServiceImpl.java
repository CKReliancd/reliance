package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.bean.UserAddress;
import com.atguigu.gmall.user.bean.UserInfo;
import com.atguigu.gmall.user.mapper.UserAddressMapper;
import com.atguigu.gmall.user.mapper.UserInfoMapper;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class UserManageServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    private String userKey_prifix="user:";
    private String userinfoKey_suffix=":info";
    private int userinfo_expire=60*60;


    @Override
    public List<UserInfo> getUserInfoListAll() {
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        UserInfo userInfoQuery = new UserInfo();
        userInfoQuery.setLoginName("ck");
        List<UserInfo> userInfos1 = userInfoMapper.select(userInfoQuery);

        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("name","张%").andEqualTo("id","3");
        List<UserInfo> userInfos2 = userInfoMapper.selectByExample(example);

        return userInfos2;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfo.setPasswd(userInfo.getPasswd());
    }

    @Override
    public void updateUser(String id, UserInfo userInfo) {
        Example example=new Example(UserInfo.class);
        example.createCriteria().andLike("name" ,"张%").andEqualTo("id","3");
        userInfoMapper.updateByExampleSelective(userInfo,example);

    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress=new UserAddress();
        userAddress.setUserId(userId);

        List<UserAddress> userAddressList = userAddressMapper.select(userAddress);

        return userAddressList;
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        userInfo.setPasswd(userInfo.getPasswd());

        UserInfo userInfoResult = userInfoMapper.selectOne(userInfo);
//        if(userInfoResult!=null){
//            Jedis jedis = redisUtil.getJedis();
//            //user:1:info
//            String userJson = JSON.toJSONString(userInfoResult);
//            jedis.setex(userKey_prefix+userInfoResult.getId()+userinfoKey_suffix,userinfo_expire,userJson);
//            jedis.close();
//            return userInfoResult;
//        }
        return userInfoResult;
    }

    @Override
    public UserInfo verify(String userId) {
        return null;
    }
}
