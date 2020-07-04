package kr.co.fastcampus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int id;
	@NonNull private String username;
	@NonNull private String password;
	
}
