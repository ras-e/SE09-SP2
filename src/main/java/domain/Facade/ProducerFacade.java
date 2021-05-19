package domain.Facade;

import Persistence.PersistenceHandler;
import domain.user.Producer;

public class ProducerFacade {

    public static boolean addedProd(Producer producer) {
        return PersistenceHandler.getInstance().addProducer(producer);
    }

//xdnicefuckupcor

}
