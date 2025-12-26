@Override
public void deactivateCategory(Long id) {
    SpendCategory sc = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    sc.setActive(false);
    repository.save(sc);
}
