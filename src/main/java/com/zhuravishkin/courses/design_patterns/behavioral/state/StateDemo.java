package com.zhuravishkin.courses.design_patterns.behavioral.state;

// Client
public class StateDemo {
    public static void main(String[] args) {
        ATMContext atm = new ATMContext();

        System.out.println("Scenario 1:");
        atm.insertCard();
        atm.enterPin(1234);
        atm.withdrawCash(100);

        System.out.println("\nScenario 2:");
        atm.insertCard();
        atm.ejectCard();
        atm.withdrawCash(100);
    }
}

// State: Интерфейс состояния
interface ATMState {
    void insertCard();

    void ejectCard();

    void enterPin(int pin);

    void withdrawCash(int amount);
}

// ConcreteState: Состояние "Нет карты"
class NoCardState implements ATMState {
    private final ATMContext atm;

    public NoCardState(ATMContext atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card inserted.");
        atm.setState(atm.getHasCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Insert a card first.");
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Insert a card first.");
    }
}

// ConcreteState: Состояние "Карта вставлена"
class HasCardState implements ATMState {
    private final ATMContext atm;

    public HasCardState(ATMContext atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setState(atm.getNoCardState());
    }

    @Override
    public void enterPin(int pin) {
        if (pin == 1234) {
            System.out.println("PIN correct.");
            atm.setState(atm.getPinVerifiedState());
        } else {
            System.out.println("PIN incorrect.");
        }
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Enter PIN first.");
    }
}

// ConcreteState: Состояние "PIN подтверждён"
class PinVerifiedState implements ATMState {
    private final ATMContext atm;

    public PinVerifiedState(ATMContext atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setState(atm.getNoCardState());
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("PIN already entered.");
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Dispensing " + amount + " cash.");
        atm.setState(atm.getNoCardState());
    }
}

// Context: Банкомат
class ATMContext {
    private final ATMState noCardState;
    private final ATMState hasCardState;
    private final ATMState pinVerifiedState;

    private ATMState currentState;

    public ATMContext() {
        noCardState = new NoCardState(this);
        hasCardState = new HasCardState(this);
        pinVerifiedState = new PinVerifiedState(this);

        currentState = noCardState;
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public ATMState getNoCardState() {
        return noCardState;
    }

    public ATMState getHasCardState() {
        return hasCardState;
    }

    public ATMState getPinVerifiedState() {
        return pinVerifiedState;
    }

    public void insertCard() {
        currentState.insertCard();
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void enterPin(int pin) {
        currentState.enterPin(pin);
    }

    public void withdrawCash(int amount) {
        currentState.withdrawCash(amount);
    }
}
