package com.femsa.oxxo.mermaautorizada.service.impl;

import com.femsa.oxxo.mermaautorizada.model.XxmapLimitesMerma;
import com.femsa.oxxo.mermaautorizada.repository.XxmapLimitesMermaRepository;
import com.femsa.oxxo.mermaautorizada.service.IxxmapLimitesMermaService;
import org.springframework.stereotype.Service;

@Service
public class XxmapLimitesMermaServiceImpl implements IxxmapLimitesMermaService {


    private final XxmapLimitesMermaRepository xxmapLimitesMermaRepository;

    public XxmapLimitesMermaServiceImpl(XxmapLimitesMermaRepository xxmapLimitesMermaRepository) {
        this.xxmapLimitesMermaRepository = xxmapLimitesMermaRepository;
    }

}
