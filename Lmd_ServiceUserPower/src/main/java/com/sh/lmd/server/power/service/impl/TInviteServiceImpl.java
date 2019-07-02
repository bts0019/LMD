package com.sh.lmd.server.power.service.impl;

import com.alibaba.fastjson.JSON;
import com.sh.common.config.ProjectConfig;
import com.sh.common.util.JedisUtil;
import com.sh.common.util.MoneyUtil;
import com.sh.common.vo.R;
import com.sh.lmd.entity.TUser;
import com.sh.lmd.server.power.dao.TInviteMapper;
import com.sh.lmd.server.power.po.MyInvitePo;
import com.sh.lmd.server.power.po.MyInviteUserPo;
import com.sh.lmd.server.power.service.TInviteService;
import com.sh.lmd.server.power.vo.MyInvite;
import com.sh.lmd.server.power.vo.MyInviteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TInviteServiceImpl implements TInviteService {

    @Autowired(required = false)
    private TInviteMapper inviteDao;

    @Autowired(required = false)
    private JedisUtil jedisUtil;

    @Override
    public R findInviteByUid(String token) {
        TUser user = JSON.parseObject(jedisUtil.get(ProjectConfig.TOKENJWT+token),TUser.class);
        MyInvitePo myInvite = inviteDao.selectInviteByUid(user.getUserId());
        MyInvite invite = new MyInvite();
        invite.setCnum(myInvite.getCnum());
        invite.setReward(MoneyUtil.TransformMoney(myInvite.getReward()));
        invite.setNum(myInvite.getNum());
        return R.setOK("",invite);
    }

    @Override
    public R findInviteUser(String token) {
        TUser user = JSON.parseObject(jedisUtil.get(ProjectConfig.TOKENJWT+token),TUser.class);
        List<MyInviteUserPo> list = inviteDao.selectInviteUser(user.getUserId());
        List<MyInviteUser> listuser = new ArrayList<>();
        Iterator<MyInviteUserPo> iter = list.iterator();
        while (iter.hasNext()){
            MyInviteUserPo myInviteUserPo = iter.next();
            MyInviteUser myInviteUser = new MyInviteUser();
            myInviteUser.setCreateTime(myInviteUserPo.getCreateTime());
            myInviteUser.setReward(MoneyUtil.TransformMoney(myInviteUserPo.getReward()));
            myInviteUser.setStatus(myInviteUserPo.getStatus());
            myInviteUser.setUserName(myInviteUserPo.getUserName());
            listuser.add(myInviteUser);
        }
        return R.setOK("",listuser);
    }
}
