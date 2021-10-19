package com.lakshyabatman.lockermanagementsystem.repository;

import com.lakshyabatman.lockermanagementsystem.exceptions.InsufficientLockerSpaceException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotAvailableException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotFoundException;
import com.lakshyabatman.lockermanagementsystem.models.Locker;
import com.lakshyabatman.lockermanagementsystem.models.LockerUser;
import com.lakshyabatman.lockermanagementsystem.models.Package;
import com.lakshyabatman.lockermanagementsystem.models.Size;

import java.util.ArrayList;

public class LockerRepository extends ILockerRepository {

    ArrayList<Locker> lockers;

    public LockerRepository() {
        lockers = new ArrayList<Locker>(10);
        for (int i = 0; i < 10; i++) {
            lockers.add(new Locker((i <= 3) ? Size.small : (i < 6) ? Size.medium : Size.large));
        }

    }

    @Override
    public Locker addPackage(Package p, LockerUser user) throws LockerNotAvailableException, InsufficientLockerSpaceException {
        for (Locker locker : lockers) {

            if (locker.isAvailable() && locker.maxSize.compareTo(p.size) >=0) {
                locker.allocate(p, user);
                return locker;
            }
        }
        throw new LockerNotAvailableException();
    }

    @Override
    public Package collectPackage(String id, LockerUser user) throws LockerNotFoundException {
        for (Locker locker : lockers) {
            if (locker.id.equals(id) && locker.user.name.equals(user.name)) {
                return locker.deallocate();
            }
        }
        throw new LockerNotFoundException();
    }
}
