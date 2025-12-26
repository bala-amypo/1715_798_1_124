@Override
public void deactivateSupplier(Long id) {
    Supplier supplier = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    supplier.setActive(false);
    repository.save(supplier);
}
