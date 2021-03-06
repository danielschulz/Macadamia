package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.examplemodels.nationalities.American;
import de.novensa.cs.performance.macadamia.examplemodels.nationalities.French;
import de.novensa.cs.performance.macadamia.examplemodels.nature.*;
import de.novensa.cs.performance.macadamia.examplemodels.personas.Homer;
import de.novensa.cs.performance.macadamia.examplemodels.personas.Marge;
import de.novensa.cs.performance.macadamia.examplemodels.personas.Peter;
import de.novensa.cs.performance.macadamia.examplemodels.sexes.Female;
import de.novensa.cs.performance.macadamia.examplemodels.sexes.Male;
import de.novensa.cs.performance.macadamia.accessors.caches.SharedClassCache;

/**
 * The auto boxing objects to test onto.
 *
 * @author Daniel Schulz
 */
public abstract class InheritanceTestObjects {

    static SharedClassCache sharedClassCache = SharedClassCache.getInstance();


    // Personas
    static final Class HOMER = (new Homer((short) 40)).getClass();
    static final Class PETER = (new Peter()).getClass();
    static final Class MARGE = (new Marge((short) 110)).getClass();

    static final Class AMERICAN = American.class;
    static final Class FRENCH = French.class;

    static final Class HUMAN = Human.class;
    static final Class LIVING_THINGS = LivingThings.class;
    static final Class SPONTANEOUS = Spontanous.class;
    static final Class TOOL_BUILDER = ToolBuilder.class;
    static final Class THINGS = Things.class;
    static final Class WORLD_ITEMS = WorldItems.class;
    static final Class HEDONIST = Hedonist.class;

    static final Class FEMALE = Female.class;
    static final Class MALE = Male.class;
}
