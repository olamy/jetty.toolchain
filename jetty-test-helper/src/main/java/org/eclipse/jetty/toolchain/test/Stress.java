package org.eclipse.jetty.toolchain.test;

import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;

/**
 * Flag indicating that {@link Test} is really used for Stress Testing.
 */
public class Stress
{
    /**
     * Returns flag indicating if <code>-DSTRESS</code> or <code>-DSTRESS=true</code> is enabled.
     * 
     * @return true if enabled
     */
    public static boolean isEnabled()
    {
        String stress = System.getProperty("STRESS");
        if (stress == null)
        {
            return false;
        }

        if (stress.equals(""))
        {
            return true;
        }

        return Boolean.parseBoolean(stress);
    }

    /**
     * Labels the test method as belonging to Stress testing.
     * <p>
     * Checks for the existence of the "STRESS" system property, if found, it allows the test to execute. If not found,
     * the test is flagged as ignored and returned.
     */
    public static void assume()
    {
        if (!isEnabled())
        {
            throw new AssumptionViolatedException("Stress testing not enabled");
        }
    }
}
