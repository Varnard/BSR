package bsr.bank2;

/**
 * Created by Varn on 2017-01-13.
 *
 "amount": int, //kwota przelewu, stawiać przecinek 2 pozycje przed końcem
 "sender_account": string, //nr. konta nadawcy
 "receiver_account": string, //nr. konta odbiorcy
 "title": string //tytuł przelewu
 */
public class Transfer {

    private int amount;
    private String sender_account;
    private String receiver_account;
    private String title;

    public Transfer() {
    }

    public Transfer(int amount, String sender_account, String receiver_account, String title) {
        this.amount = amount;
        this.sender_account = sender_account;
        this.receiver_account = receiver_account;
        this.title = title;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSender_account(String sender_account) {
        this.sender_account = sender_account;
    }

    public void setReceiver_account(String receiver_account) {
        this.receiver_account = receiver_account;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public String getSender_account() {
        return sender_account;
    }

    public String getReceiver_account() {
        return receiver_account;
    }

    public String getTitle() {
        return title;
    }
}
