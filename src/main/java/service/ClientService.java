package service;

import model.Client;
import model.Discount;
import util.Voucher;

import java.util.List;

/**
 * Mostrar todas las cosas del perfil (Nickname, PhoneNumber)
 * EL PUNTAJE ES POR ZONA, podriamos fijarnos con el socring.
 */

public class ClientService {

    private Client client;

    public ClientService(Client client) {
        this.client = client;
    }

    public Integer showScore(Client client) {
        return client.getAccumulatedScore();
    }

    public List<Discount> showDiscounts(Client client) {
        return client.getDiscounts();
    }

    public  List<Voucher> showVouchers(Client client) {
        return client.getVouchers();
    }

    public Integer showPhoneNumber(Client client) { return client.getPhoneNumber(); }

    public String showNickname(Client client) { return client.getNickname(); }

    public void buyDiscount(Discount discount) {
        client.useScore(discount.getMinScore());
        client.addDiscounts(discount);
    }

    public void useDiscount(Discount discount) {
        client.useDiscount(discount);
    }

    public void useVoucher(Voucher voucher) {
        client.useVoucher(voucher);
    }
}
