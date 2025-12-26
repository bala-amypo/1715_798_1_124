@Override
public UserAccount findByEmailOrThrow(String email) {
    return repository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
}
