insert into test (id, name, state) values (1, 'This is the first test', 'on');
insert into test (id, name, state) values (2, 'This is the second test', 'planned');
insert into test (id, name, state) values (3, 'This is the third test', 'off');

insert into Problem (problem_id, difficulty, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (1, 'easy', 1, 'Ki vagyok en?', 'Orsi', 'Zsorsi', 'Porsi', 'Florsi');
insert into Problem (problem_id, difficulty, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (2, 'easy', 1, 'Hany eves vagyok?', '26', '11', '45', '36');
insert into Problem (problem_id, difficulty, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (3, 'easy', 1, 'Ki vagy te?', 'kaka', 'maka', 'batman', 'robin');

insert into user_eminens (id, username, password, salt, full_name, role) values(1, 'TestTeacher',
    'pKpDWv8IA8XTR8Ld8Jyqy+ooGVtYSXgtwlZq3LmDcy+Bo/O+Sb+WF9au3RS0khhnqN1r7QUH1Qnhhb2s0I8tgA==',
    'k/kKB1ECWC2YdLTIHPJp+iiCnrgssEYjqUJa78De/vdXYCWsAtUgzw2VKfEgPxIdl5Ej+T4ar+WRO3y3LgFW79cKvrVEsDkbyCsNbBqZ6heyKbbLow9k9iMT5tq+JS+R4was1UEpN63w0fRwrcDlOWZBGIZJ5JsVlbhdE+NDcqDO+tUfQ6iPAd/ae17HDgw99tToQ3xWNIeBSGq3kYB5D96bfU8V5yFzuhfL956vh1faNJylxC9jf9buYk+YyEWySJK2aHTfWq6I4yCmldMI4LZRJk0aBDBpfTJO79HP2fTeGo/h7xInzkT6eJ5Tm9kCrey6ZEOgV/OQS7T5mtzzAnhMEmCr/p9aQA34HRon5FWVUu987yLpqV56v2PyvQy4r9L9hROebVZkR4NNb9HMJzu4NmPVVAF1HNA2X5lWSMQe3p56NJUK8o5UP/E7FsJ605wSMqMadbi7vS6Y6xYw8hOl8UH5y9wUPKwq9AHjqmkIBCqZHniBMFZUdkX4ePnFqG/pW1+oTreG4v01rXWHrEO50PyABS57DgP3znhltnLBk60LxndK+ZX2KhBX7c8tZZX9PIK9WuH/mx7CvEK6RZwt5GswNtkeSJEO2rtzpL9hoTr+CdIz184MuVX2RhSYoQQaEpLV8pUHL0slTWjXU8Ni+N3pKAYcGTQbT0yvBr8=',
    'Test Teacher', 'teacher'
    );

insert into user_eminens (id, username, password, salt, full_name, role) values(2, 'TestWatcher',
    'pKpDWv8IA8XTR8Ld8Jyqy+ooGVtYSXgtwlZq3LmDcy+Bo/O+Sb+WF9au3RS0khhnqN1r7QUH1Qnhhb2s0I8tgA==',
    'k/kKB1ECWC2YdLTIHPJp+iiCnrgssEYjqUJa78De/vdXYCWsAtUgzw2VKfEgPxIdl5Ej+T4ar+WRO3y3LgFW79cKvrVEsDkbyCsNbBqZ6heyKbbLow9k9iMT5tq+JS+R4was1UEpN63w0fRwrcDlOWZBGIZJ5JsVlbhdE+NDcqDO+tUfQ6iPAd/ae17HDgw99tToQ3xWNIeBSGq3kYB5D96bfU8V5yFzuhfL956vh1faNJylxC9jf9buYk+YyEWySJK2aHTfWq6I4yCmldMI4LZRJk0aBDBpfTJO79HP2fTeGo/h7xInzkT6eJ5Tm9kCrey6ZEOgV/OQS7T5mtzzAnhMEmCr/p9aQA34HRon5FWVUu987yLpqV56v2PyvQy4r9L9hROebVZkR4NNb9HMJzu4NmPVVAF1HNA2X5lWSMQe3p56NJUK8o5UP/E7FsJ605wSMqMadbi7vS6Y6xYw8hOl8UH5y9wUPKwq9AHjqmkIBCqZHniBMFZUdkX4ePnFqG/pW1+oTreG4v01rXWHrEO50PyABS57DgP3znhltnLBk60LxndK+ZX2KhBX7c8tZZX9PIK9WuH/mx7CvEK6RZwt5GswNtkeSJEO2rtzpL9hoTr+CdIz184MuVX2RhSYoQQaEpLV8pUHL0slTWjXU8Ni+N3pKAYcGTQbT0yvBr8=',
    'Test Watcher', 'watcher'
    );

insert into user_eminens (id, username, password, salt, full_name, role) values(3, 'TestStudent',
    'pKpDWv8IA8XTR8Ld8Jyqy+ooGVtYSXgtwlZq3LmDcy+Bo/O+Sb+WF9au3RS0khhnqN1r7QUH1Qnhhb2s0I8tgA==',
    'k/kKB1ECWC2YdLTIHPJp+iiCnrgssEYjqUJa78De/vdXYCWsAtUgzw2VKfEgPxIdl5Ej+T4ar+WRO3y3LgFW79cKvrVEsDkbyCsNbBqZ6heyKbbLow9k9iMT5tq+JS+R4was1UEpN63w0fRwrcDlOWZBGIZJ5JsVlbhdE+NDcqDO+tUfQ6iPAd/ae17HDgw99tToQ3xWNIeBSGq3kYB5D96bfU8V5yFzuhfL956vh1faNJylxC9jf9buYk+YyEWySJK2aHTfWq6I4yCmldMI4LZRJk0aBDBpfTJO79HP2fTeGo/h7xInzkT6eJ5Tm9kCrey6ZEOgV/OQS7T5mtzzAnhMEmCr/p9aQA34HRon5FWVUu987yLpqV56v2PyvQy4r9L9hROebVZkR4NNb9HMJzu4NmPVVAF1HNA2X5lWSMQe3p56NJUK8o5UP/E7FsJ605wSMqMadbi7vS6Y6xYw8hOl8UH5y9wUPKwq9AHjqmkIBCqZHniBMFZUdkX4ePnFqG/pW1+oTreG4v01rXWHrEO50PyABS57DgP3znhltnLBk60LxndK+ZX2KhBX7c8tZZX9PIK9WuH/mx7CvEK6RZwt5GswNtkeSJEO2rtzpL9hoTr+CdIz184MuVX2RhSYoQQaEpLV8pUHL0slTWjXU8Ni+N3pKAYcGTQbT0yvBr8=',
    'Test Student', 'student'
);

update hibernate_sequence set next_val = 4;