package com.aaulaundary.aau_laundary_system.Services;

import com.aaulaundary.aau_laundary_system.models.LaundaryOrder;

public interface LaundaryOrderServices {
    public LaundaryOrder saveLaundarOrder(LaundaryOrder clothe);
    public LaundaryOrder findOrder(Long id);
    public void updateOrder(Long id,LaundaryOrder laundaryOrder);

}
