package hu.oe.nik.szfmv17t.automatedcar.bus;

import hu.oe.nik.szfmv17t.automatedcar.SystemComponent;

import static org.junit.Assert.assertEquals;

public class VirtualFunctionBusTest {

	@org.junit.Before
	public void registerComponent(){
		SystemComponentMock comp = new SystemComponentMock();
		VirtualFunctionBus.registerComponent(comp);
	}

	@org.junit.Test
	public void sendSignalTest(){
		VirtualFunctionBus.sendSignal(new Signal(0,42));
	}


	class SystemComponentMock extends SystemComponent{

		@Override
		public void loop() {

		}

		@Override
		public void receiveSignal(Signal s) {
			if (s.getId() == 0){
				assertEquals(s.getData(), 42);
			}
		}
	}
}
