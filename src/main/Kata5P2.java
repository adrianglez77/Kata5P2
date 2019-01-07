package main;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReaderBD;

public class Kata5P2 {
	
	public static void main(String[] args) {	
		Kata5P2 kata = new Kata5P2("KATA5P2.db");	
		kata.execute();
	}
	
	private final String database;
	private List<Mail> mails;
	private Histogram<String> histogram;
	private HistogramDisplay display;

	public Kata5P2(final String database) {
		this.database = database;
	}
	
	private void execute() {	
		input();	
		process();		
		output();		
	}
	
	private void input() {
		mails = MailListReaderBD.read(database);
	}
	
	private void process() {
		histogram = MailHistogramBuilder.build(mails);
	}
	
	private void output() {
		display = new HistogramDisplay(histogram);
		display.execute();
	}
}