package JUnitTests;

import Model.Enums.EnumDimensions;
import Model.Enums.EnumSeats;
import Model.Theaters.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Test for all kinds of theaters - Standard, Vip and MultiDimension theaters.
// For each theater kind, checking if there's X seats available.
public class TheatersTests {
    private StandardTheater st = null;
    private VipTheater vip = null;
    private MultiDimTheater imax = null;

    // Setting all seats as 'available'.
    @BeforeEach
    void setUp() {
        st = new StandardTheater(2); // 4x5
        st.setSeat(2, 2, EnumSeats.AVAILABLE);
        for(int i=0; i<4; i++) {
            for(int j=0; j<5; j++) {
                st.setSeat(i+1, j+1, EnumSeats.AVAILABLE);
            }
        }
        vip = new VipTheater(5); // 3x5
        for(int i=0; i<3; i++) {
            for(int j=0; j<5; j++) {
                vip.setSeat(i+1, j+1, EnumSeats.AVAILABLE);
            }
        }
        imax = new MultiDimTheater(7, EnumDimensions.IMAX); // 5x6
        for(int i=0; i<5; i++) {
            for(int j=0; j<6; j++) {
                imax.setSeat(i+1, j+1, EnumSeats.AVAILABLE);
            }
        }
    }

    @Test
    void standardSuccessTest() {
        st.selectSeat(1,1);
        st.selectSeat(1,2);
        st.selectSeat(1,3);
        st.selectSeat(1,4);
        st.selectSeat(1,5);
        st.selectSeat(2,1);
        st.selectSeat(2,2);
        st.selectSeat(2,3);
        st.selectSeat(2,4);
        st.selectSeat(2,5);

        assertTrue(st.isValidNumberOfTickets(8));
        assertTrue(st.isValidNumberOfTickets(10));
    }

    @Test
    void standardFailureTest() {
        st.selectSeat(1,1);
        st.selectSeat(1,2);
        st.selectSeat(1,3);
        st.selectSeat(1,4);
        st.selectSeat(1,5);
        st.selectSeat(2,1);
        st.selectSeat(2,2);
        st.selectSeat(2,3);
        st.selectSeat(2,4);
        st.selectSeat(2,5);

        assertFalse(st.isValidNumberOfTickets(18));
        assertFalse(st.isValidNumberOfTickets(11));
    }

    @Test
    void vipSuccessTest() {
        vip.selectSeat(1,1);
        vip.selectSeat(1,2);
        vip.selectSeat(1,3);
        vip.selectSeat(1,4);
        vip.selectSeat(1,5);
        vip.selectSeat(2,1);
        vip.selectSeat(2,2);
        vip.selectSeat(2,3);
        vip.selectSeat(2,4);
        vip.selectSeat(2,5);

        assertTrue(vip.isValidNumberOfTickets(3));
        assertTrue(vip.isValidNumberOfTickets(5));
    }

    @Test
    void vipFailureTest() {
        vip.selectSeat(1,1);
        vip.selectSeat(1,2);
        vip.selectSeat(1,3);
        vip.selectSeat(1,4);
        vip.selectSeat(1,5);
        vip.selectSeat(2,1);
        vip.selectSeat(2,2);
        vip.selectSeat(2,3);
        vip.selectSeat(2,4);
        vip.selectSeat(2,5);

        assertFalse(vip.isValidNumberOfTickets(8));
        assertFalse(vip.isValidNumberOfTickets(15));
    }

    @Test
    void imaxSuccessTest() {
        imax.selectSeat(1,1);
        imax.selectSeat(1,2);
        imax.selectSeat(1,3);
        imax.selectSeat(1,4);
        imax.selectSeat(1,5);
        imax.selectSeat(2,1);
        imax.selectSeat(2,2);
        imax.selectSeat(2,3);
        imax.selectSeat(2,4);
        imax.selectSeat(2,5);
        imax.selectSeat(3,1);
        imax.selectSeat(3,2);
        imax.selectSeat(3,3);
        imax.selectSeat(3,4);
        imax.selectSeat(3,5);

        assertTrue(imax.isValidNumberOfTickets(15));
        assertTrue(imax.isValidNumberOfTickets(10));
    }

    @Test
    void imaxFailureTest() {
        imax.selectSeat(1,1);
        imax.selectSeat(1,2);
        imax.selectSeat(1,3);
        imax.selectSeat(1,4);
        imax.selectSeat(1,5);
        imax.selectSeat(2,1);
        imax.selectSeat(2,2);
        imax.selectSeat(2,3);
        imax.selectSeat(2,4);
        imax.selectSeat(2,5);
        imax.selectSeat(3,1);
        imax.selectSeat(3,2);
        imax.selectSeat(3,3);
        imax.selectSeat(3,4);
        imax.selectSeat(3,5);

        assertFalse(imax.isValidNumberOfTickets(16));
        assertFalse(imax.isValidNumberOfTickets(20));
    }
}
