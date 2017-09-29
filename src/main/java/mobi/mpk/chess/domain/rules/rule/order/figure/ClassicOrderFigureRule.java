package mobi.mpk.chess.domain.rules.rule.order.figure;

import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.figure.*;

import java.util.LinkedList;
import java.util.List;

public class ClassicOrderFigureRule implements OrderFigureRule {

    @Override
    public List<Figure> orderFigure(Color color) {

        List<FactoryFigure> creators = new LinkedList<FactoryFigure>();
        List<Figure> orderFigures = new LinkedList<Figure>();

        creators.add(new FactoryRook());
        creators.add(new FactoryKnight());
        creators.add(new FactoryBishop());
        creators.add(new FactoryQueen());
        creators.add(new FactoryKing());
        creators.add(new FactoryBishop());
        creators.add(new FactoryKnight());
        creators.add(new FactoryRook());

        for (int i = 0; i < 8; i++) {

            creators.add(new FactoryPawn());

        }


        for (FactoryFigure creator : creators) {
            orderFigures.add(creator.factoryMethod(color));
        }


        return orderFigures;

    }

}
