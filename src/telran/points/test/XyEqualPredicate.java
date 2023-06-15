package telran.points.test;

import java.util.function.Predicate;

import telran.points.Point;

public class XyEqualPredicate implements Predicate<Point> {

	@Override
	public boolean test(Point t) {
		// TODO Auto-generated method stub
		return t.getX()==t.getY();
	}

}
