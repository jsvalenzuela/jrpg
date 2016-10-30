package connection;

import java.io.DataInputStream;
import java.util.concurrent.LinkedBlockingQueue;

import com.google.gson.Gson;

public class ReceiveThread extends Thread {

	private String msj;
	private LinkedBlockingQueue<String> outgoingMessages;
	private DataInputStream in;
	private Gson gson;

	public ReceiveThread(LinkedBlockingQueue<String> outgoingMes, DataInputStream dataIn) {
		this.outgoingMessages = outgoingMes;
		this.in = dataIn;
		gson = new Gson();
	}

	public void run() {
		try {
			while (true) {
				this.msj = leerRespuesta();
				outgoingMessages.add(msj);
			}
		} catch (Exception e) {
			//"Error recibiendo el mensaje;
		}
	}

	synchronized public String leerRespuesta() {
		try {
			return gson.fromJson(in.readUTF(), String.class);
		} catch (Exception e) {
			//Error leerMEnsaje
		}
		return null;
	}
}