package it.fiat.manual.jse.jpa;

import java.util.List;

import it.fiat.manual.jse.jpa.service.FiatMakeRepo;

public class Main {

	public static void main(String[] args) {
		FiatMakeRepo fiatMakeRepo = new FiatMakeRepo();
		fiatMakeRepo.getAll();

	}
}
