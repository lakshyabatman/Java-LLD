package com.lakshyabatman.lockermanagementsystem.models;

import com.lakshyabatman.lockermanagementsystem.exceptions.InsufficientLockerSpaceException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotAvailableException;

public class Locker {

    public Package p;

    public String id;


    public Size maxSize;

    public LockerUser user;


    public Locker(Size maxSize) {
        id = Double.toString(Math.random() * 41);
        this.maxSize = maxSize;
    }


    public boolean isAvailable() {
        return p == null;
    }

    public void allocate(Package p, LockerUser user) throws LockerNotAvailableException, InsufficientLockerSpaceException {
        if (!isAvailable()) throw new LockerNotAvailableException();
        if (maxSize.compareTo(p.size) < 0) throw new InsufficientLockerSpaceException();
        this.p = p;
        this.user = user;

    }

    public Package deallocate() {
        Package p= this.p;
        this.p = null;
        return p;
    }
}
