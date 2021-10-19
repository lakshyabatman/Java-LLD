package com.lakshyabatman.lockermanagementsystem.repository;

import com.lakshyabatman.lockermanagementsystem.exceptions.InsufficientLockerSpaceException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotAvailableException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotFoundException;
import com.lakshyabatman.lockermanagementsystem.models.Locker;
import com.lakshyabatman.lockermanagementsystem.models.LockerUser;
import com.lakshyabatman.lockermanagementsystem.models.Package;


public abstract class ILockerRepository {

    public abstract Locker addPackage(Package p, LockerUser user) throws LockerNotAvailableException, InsufficientLockerSpaceException;

    public abstract Package collectPackage(String id, LockerUser user) throws LockerNotFoundException;



}
