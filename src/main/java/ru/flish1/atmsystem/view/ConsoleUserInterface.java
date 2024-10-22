package ru.flish1.atmsystem.view;

public class ConsoleUserInterface {
    /*private static final Logger log = LoggerFactory.getLogger(ConsoleUserInterface.class);
    private final AuthService authService;
    private final UserInput inputHandler;


    public ConsoleUserInterface() {
        inputHandler = new ConsoleUserInput();
        authService = new AuthService();
    }

    @Override
    public void displayMainMenu() {
        message("""
                                     -----------
                 ---- Добро пожаловать в симуляцию системы банкомата ----
                                     -----------
                                \s
                      Для начала необходимо зайти в систему
                         1  Авторизация
                         2  Создание нового счета
                \s""");
        String input = checkUserCommand("Введите команду: ", "1", "2");
        switch (input) {
            case "1" -> displayAuthMenu();
            case "2" -> registrationAccountMenu();
            default -> displayMainMenu();
        }
    }

    public void registrationAccountMenu() {
        message("""
                                     -----------
                 ---- Добро пожаловать в симуляцию системы банкомата ----
                                     -----------
                \s
                         Это страница создания нового счета
                \s""");
        log.debug("test");

        User user = registrationUser();

        log.info(user.toString());
    }

    private User registrationUser() {
        String firstName = inputHandler.handleUserActions(" Введите имя: ");
        String lastName = inputHandler.handleUserActions("Введите фамилию: ");
        String secondName = inputHandler.handleUserActions("Введите отчество (если нет оставляйте поле пустым): ");
        Integer seriesPassport = Integer.valueOf(inputHandler.handleUserActions("Введите серию паспорта: "));
        Integer numberPassport = Integer.valueOf(inputHandler.handleUserActions("Введите номер паспорта: "));

        User user = authService.signUpUser(firstName, lastName, secondName, seriesPassport, numberPassport);

        message("Пользователь \"%s\" авторизирован %s", List.of(user.getFirstName(), user.toString()));
        return user;
    }

    public void displayAuthMenu() {

    }

    private String checkUserCommand(String text, String... command) {
        String userText = inputHandler.handleUserActions(text);
        inputHandler.checkExitCommand(userText);
        if (userText.isEmpty()) {
            messageErrorInput("Вы ввели пустую строчку, повторите ввод");
            userText = checkUserCommand(text, command);
        }

        if (command.length != 0 && !String.join("", command).contains(userText)) {
            messageErrorInput("Введена неизвестная команда, повторите ввод");
            userText = checkUserCommand(text, command);
        }
        return userText;
    }

    private void messageErrorInput(String message) {
        System.out.println(message);
        System.out.printf("Для того что бы отменить ввод введите %s\n", inputHandler.getCommandExit());
    }

    private void message(String message) {
        System.out.println(message);
    }

    private void message(String message, List<String> listArgs) {
        System.out.printf(message + "\n", listArgs.toArray());
    }*/
}
