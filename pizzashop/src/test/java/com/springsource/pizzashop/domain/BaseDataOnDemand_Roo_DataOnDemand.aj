package com.springsource.pizzashop.domain;

import com.springsource.pizzashop.domain.Base;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect BaseDataOnDemand_Roo_DataOnDemand {
    
    declare @type: BaseDataOnDemand: @Component;
    
    private Random BaseDataOnDemand.rnd = new SecureRandom();
    
    private List<Base> BaseDataOnDemand.data;
    
    public Base BaseDataOnDemand.getNewTransientBase(int index) {
        com.springsource.pizzashop.domain.Base obj = new com.springsource.pizzashop.domain.Base();
        obj.setName("name_" + index);
        return obj;
    }
    
    public Base BaseDataOnDemand.getSpecificBase(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Base obj = data.get(index);
        return Base.findBase(obj.getId());
    }
    
    public Base BaseDataOnDemand.getRandomBase() {
        init();
        Base obj = data.get(rnd.nextInt(data.size()));
        return Base.findBase(obj.getId());
    }
    
    public boolean BaseDataOnDemand.modifyBase(Base obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void BaseDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.springsource.pizzashop.domain.Base.findBaseEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Base' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.springsource.pizzashop.domain.Base>();
        for (int i = 0; i < 10; i++) {
            com.springsource.pizzashop.domain.Base obj = getNewTransientBase(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
