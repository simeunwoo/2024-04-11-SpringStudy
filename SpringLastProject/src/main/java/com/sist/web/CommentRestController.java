package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentRestController {

	@Autowired
	private CommentService cService;
}
