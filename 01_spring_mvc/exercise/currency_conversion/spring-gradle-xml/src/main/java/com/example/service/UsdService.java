package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class UsdService implements IUsdService {
    @Override
    public int usdNumber(String usd) {
        int result = Integer.parseInt(usd) * 23000;
        return result;

    }
}
