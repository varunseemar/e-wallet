package com.demo.e_wallet.common;

import java.util.List;

public interface CommonAdapter <E,M>{
    M save(E e);
    M update(long id,E e);
    List<M> getAll();
    boolean delete(long id);
    M getById(long id);
}
