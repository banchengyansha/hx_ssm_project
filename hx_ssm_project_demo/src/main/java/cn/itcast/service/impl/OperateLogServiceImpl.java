package cn.itcast.service.impl;

import cn.itcast.domain.OperateLog;
import cn.itcast.mapper.OperateLogMapper;
import cn.itcast.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(OperateLog operateLog) {
        operateLogMapper.insert(operateLog);
    }
}
