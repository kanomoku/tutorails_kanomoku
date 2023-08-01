package javabasic.enumprac;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class Pizza {

    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses = EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    private PizzaStatus status;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum PizzaStatus {
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        }, READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        }, DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }

        // 下单
        public boolean isOrdered() {
            return false;
        }

        // 准备
        public boolean isReady() {
            return false;
        }

        // 交付
        public boolean isDelivered() {
            return false;
        }

        @JsonProperty("timeToDelivery")
        public int getTimeToDelivery() {
            return timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " + this.getStatus().getTimeToDelivery() + " days");
    }

    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        return input.stream().filter((s) -> undeliveredPizzaStatuses.contains(s.getStatus())).collect(Collectors.toList());
    }

    public static EnumMap<PizzaStatus, List<Pizza>> groupPizzaByStatus(List<Pizza> pizzaList) {
        EnumMap<PizzaStatus, List<Pizza>> pzByStatus = new EnumMap<PizzaStatus, List<Pizza>>(PizzaStatus.class);

        for (Pizza pz : pizzaList) {
            PizzaStatus status = pz.getStatus();
            if (pzByStatus.containsKey(status)) {
                pzByStatus.get(status).add(pz);
            } else {
                List<Pizza> newPzList = new ArrayList<Pizza>();
                newPzList.add(pz);
                pzByStatus.put(status, newPzList);
            }
        }
        return pzByStatus;
    }

    public static EnumMap<PizzaStatus, List<Pizza>> groupPizzaByStatus2(List<Pizza> pzList) {
        EnumMap<PizzaStatus, List<Pizza>> map = pzList.stream().filter(a -> a != null && a.getStatus() != null).collect(Collectors.groupingBy(Pizza::getStatus, () -> new EnumMap<>(PizzaStatus.class), Collectors.toList()));
        return map;
    }

    public static Map<PizzaStatus, List<Pizza>> groupPizzaByStatus3(List<Pizza> pizzaList) {
        Map<PizzaStatus, List<Pizza>> collect = pizzaList.stream().filter(a -> a != null && a.getStatus() != null).collect(Collectors.groupingBy(Pizza::getStatus));
        return collect;
    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy().deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }
}


