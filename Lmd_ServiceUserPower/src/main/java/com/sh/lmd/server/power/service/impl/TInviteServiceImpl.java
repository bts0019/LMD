package com.sh.lmd.server.power.service.impl;

import com.sh.common.util.MoneyUtil;
import com.sh.common.vo.R;
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

    @Autowired
    private TInviteMapper inviteDao;

    @Override
    public R findInviteByUid(Integer uid) {
        MyInvitePo myInvite = inviteDao.selectInviteByUid(uid);
        MyInvite invite = new MyInvite();
        invite.setCnum(myInvite.getCnum());
        invite.setReward(MoneyUtil.TransformMoney(myInvite.getReward()));
        invite.setNum(myInvite.getNum());
        return R.setOK("",invite);
    }

    @Override
    public R findInviteUser(Integer uid) {
        List<MyInviteUserPo> list = inviteDao.selectInviteUser(uid);
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
