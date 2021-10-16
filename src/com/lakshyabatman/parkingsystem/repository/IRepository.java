package com.lakshyabatman.parkingsystem.repository;

import com.lakshyabatman.parkingsystem.DAO.IDAO;

abstract class IRepository<T> {

    abstract public T create(IDAO dao);

}
