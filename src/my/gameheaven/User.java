package my.gameheaven;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = -1178561973660991852L;

	@NonNull
	private String id;
	@NonNull
	private String password;
	private List<Game> games = new ArrayList<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public boolean isValidPassword(String password) {
		return this.password.equals(password);
	}

}

// id를 입력하면
// A게임에서 몇승몇패
// B게임에서 몇승몇패
// C게임에서 몇승몇패
// D게임에서 몇승몇패
// E게임에서 몇승몇패

// ID마다 전적?