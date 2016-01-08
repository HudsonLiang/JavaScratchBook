package roadrotation.regulation;

import java.time.LocalDateTime;

import roadrotation.Transition;

public interface Rule {

	Transition apply(LocalDateTime instant);

}
