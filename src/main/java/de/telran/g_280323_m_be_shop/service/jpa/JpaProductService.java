package de.telran.g_280323_m_be_shop.service.jpa;

import de.telran.g_280323_m_be_shop.domain.entity.common.CommonProduct;
import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Product;
import de.telran.g_280323_m_be_shop.domain.entity.jpa.JpaProduct;
import de.telran.g_280323_m_be_shop.domain.entity.jpa.Task;
import de.telran.g_280323_m_be_shop.repository.jpa.JpaProductRepository;
import de.telran.g_280323_m_be_shop.schedule.ScheduleExecutor;
import de.telran.g_280323_m_be_shop.service.interfaces.ProductService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaProductService implements ProductService {

    private final Logger LOGGER = LogManager.getLogger(JpaProductService.class);

    private JpaProductRepository repository;
    private TaskService taskService;

    public JpaProductService(JpaProductRepository repository, TaskService taskService) {
        this.repository = repository;
        this.taskService = taskService;
    }

    @Override
    public List<Product> getAll() {
        Task task = taskService.createTask("Запрошен список всех продуктов");
        ScheduleExecutor.executeScheduledTask(task);
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Product getById(int id) {
//        LOGGER.log(Level.INFO, "Запрошен продукт с идентификатором {}.", id);
//        LOGGER.log(Level.WARN, "Запрошен продукт с идентификатором {}.", id);
//        LOGGER.log(Level.ERROR, "Запрошен продукт с идентификатором {}.", id);

        LOGGER.info("Запрошен продукт с идентификатором {}.", id);
        LOGGER.warn("Запрошен продукт с идентификатором {}.", id);
        LOGGER.error("Запрошен продукт с идентификатором {}.", id);

        return repository.findById(id).orElse(null);
    }

    @Override
    public void add(Product product) {

        // Здесь отрабатывает внедрённый код @Before

        repository.save(new JpaProduct(product.getId(), product.getName(), product.getPrice()));
        // Следующая строка - в учебных целях, для тестирования АОП
        // Ни на что не влияет
        ((CommonProduct) product).setId(777);

        // Здесь отрабатывает внедрённый код @After
    }

    @Override
    public void deleteById(int id) {
        Task task = taskService.createTask("Попытка удаления продукта с ИД " + id);
        LOGGER.info("Вызван метод deleteById");
        ScheduleExecutor.executeScheduledTaskOnce(task);
        repository.deleteById(id);
    }

    @Override
    public int getCount() {
        return (int) repository.count();
    }

    @Override
    public double getTotalPrice() {
        return repository.getTotalPrice();
    }

    @Override
    public double getAveragePrice() {
        return repository.getAveragePrice();
    }

    @Override
    public void deleteByName(String name) {
        repository.deleteByName(name);
    }
}