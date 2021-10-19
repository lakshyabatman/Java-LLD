package com.lakshyabatman.lockermanagementsystem.service;

import com.lakshyabatman.lockermanagementsystem.exceptions.InsufficientLockerSpaceException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotAvailableException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotFoundException;
import com.lakshyabatman.lockermanagementsystem.models.Locker;
import com.lakshyabatman.lockermanagementsystem.models.LockerUser;
import com.lakshyabatman.lockermanagementsystem.models.Package;
import com.lakshyabatman.lockermanagementsystem.repository.ILockerRepository;

public class LockerService {

    final ILockerRepository lockerRepository;


    public LockerService(ILockerRepository lockerRepository) {
        this.lockerRepository = lockerRepository;
    }

    public Locker allocateLocker(LockerUser user, Package p) throws LockerNotAvailableException, InsufficientLockerSpaceException {
            return lockerRepository.addPackage(p,user);
    }

    public Package freeLocker(String lockerID,LockerUser user) throws LockerNotFoundException {
        return lockerRepository.collectPackage(lockerID,user);

    }



}
